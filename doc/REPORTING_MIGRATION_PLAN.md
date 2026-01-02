# Migration Plan: Turnus Reporting to Apache ECharts & JSON

## 1. Executive Summary
This document outlines the plan to modernize the Turnus reporting system. The goal is to transition from the current **Markdown-to-HTML** generation (handled in Java) to a **Data-Driven** approach where Java outputs structured **JSON**, and the visualization is handled by a frontend layer (VS Code Webview or Browser) using **Apache ECharts**.

## 2. Architecture Overview

### Current State (Legacy)
*   **Logic**: Java classes concatenate Strings to build Markdown.
*   **Rendering**: `HtmlUtils` uses CommonMark to convert Markdown to static HTML.
*   **Visualization**: Static images or simple HTML tables. Limited interactivity.
*   **Math**: Rendered as static text or requires external plugins.

### Future State (Target)
*   **Logic**: Java classes build a structured `Report` object model.
*   **Output**: A standardized JSON file (e.g., `analysis_report.json`).
*   **Rendering**: A generic "Report Viewer" (Web/VS Code) reads the JSON.
*   **Visualization**: 
    *   **Charts**: Apache ECharts (Interactive, Zoomable, Responsive).
    *   **Math**: KaTeX (High-quality LaTeX rendering).
    *   **Tables**: Interactive HTML tables (Sortable, Filterable).

## 3. JSON Data Schema
The core of the new system is the JSON structure. It treats a report as a list of "Blocks".

```json
{
  "reportTitle": "Partitioning Analysis",
  "generatedAt": "2026-01-02T12:00:00Z",
  "blocks": [
    {
      "type": "markdown",
      "content": "## Executive Summary\nAnalysis converged in 45ms."
    },
    {
      "type": "kpi_grid",
      "items": [
        { "label": "Total Load", "value": "4500", "unit": "MOPS" },
        { "label": "Cut Size", "value": "120", "unit": "Edges" }
      ]
    },
    {
      "type": "echart",
      "title": "Processor Load Distribution",
      "option": { 
        // Standard Apache ECharts Option Object
        "xAxis": { "type": "category", "data": ["CPU0", "CPU1"] },
        "yAxis": { "type": "value" },
        "series": [{ "data": [120, 200], "type": "bar" }]
      }
    },
    {
      "type": "latex",
      "content": "Cost function: $$ C = \\sum_{i=0}^{N} w_i $$"
    },
    {
      "type": "table",
      "headers": ["Actor", "Partition", "Weight"],
      "rows": [
        ["Filter_A", "0", "100"],
        ["Filter_B", "1", "50"]
      ]
    }
  ]
}
```

## 4. Implementation Plan

### Phase 1: Java Backend (Data Layer)
**Goal**: Enable Turnus to produce the JSON output.

1.  **Dependency Management**:
    *   Ensure a JSON library is available (Gson or Jackson). Turnus already has `javax.json` and `gson` in the target platform.
2.  **Data Model Creation**:
    *   Create a package `turnus.model.report`.
    *   Define POJOs: `Report`, `ReportBlock` (abstract), `ChartBlock`, `TableBlock`, `TextBlock`.
3.  **Refactor Exporters**:
    *   Create a generic `JsonReportExporter` interface.
    *   Modify existing analysis exporters (e.g., `Bottlenecks2HtmlExporter`) to populate these POJOs instead of building Strings.

### Phase 2: Frontend Visualization (Viewer Layer)
**Goal**: Create a way to view the JSON files.

1.  **Viewer Template**:
    *   Create a standalone HTML template (`report_viewer.html`).
    *   Include libraries via CDN or local bundle:
        *   `echarts.min.js`
        *   `katex.min.js`
        *   `marked.js` (for the text blocks)
2.  **Rendering Logic**:
    *   Write a JavaScript function that fetches `report.json`.
    *   Iterate through `blocks`.
    *   Dynamically create DOM elements based on `block.type`.
    *   Initialize ECharts instances for `echart` blocks.

### Phase 3: VS Code Integration
**Goal**: Seamless experience for the user.

1.  **Custom Editor**:
    *   Register a `CustomReadonlyEditorProvider` in `turnus.ui`.
    *   Bind it to `*.turnus.json` files.
    *   Embed the HTML/JS from Phase 2 into the Webview.
2.  **Live Preview**:
    *   Allow the user to run an analysis and immediately see the ECharts report open in a side panel.

## 5. Migration Checklist

- [ ] **Step 1**: Create `turnus.model.report` package and POJOs.
- [ ] **Step 2**: Implement `ReportToJsonSerializer` (using Gson/Jackson).
- [ ] **Step 3**: Create a prototype `report_template.html` with ECharts and KaTeX support.
- [ ] **Step 4**: Pick one analysis (e.g., Partitioning) and rewrite its Exporter to use the new system.
- [ ] **Step 5**: Verify the end-to-end flow (Run CLI -> Get JSON -> Open in Viewer).
- [ ] **Step 6**: Port remaining reports (Profiling, Bottlenecks, Trace).
- [ ] **Step 7**: Remove legacy FlexMark/CommonMark code once all reports are migrated.

## 6. Technology Stack Summary
*   **Data Format**: JSON
*   **Charting**: Apache ECharts 5.x
*   **Math**: KaTeX
*   **Text**: CommonMark (JS version) or Marked.js
*   **Tables**: HTML5 Tables (styled) or Ag-Grid (Community)
