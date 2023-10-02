package turnus.analysis.dot;

import java.awt.Color;
import java.nio.file.Path;

import turnus.common.TurnusException;
import turnus.common.io.Emitter;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

public class NetworkToDot {

	private Network network;
	protected Emitter emitter;

	public NetworkToDot(Network network) {
		this.network = network;
		this.emitter = new Emitter();
	}

	public void emit(Path path) {
		try {
			// -- Open file
			emitter.open(path);

			// -- network
			network();

			// -- Close file
			emitter.close();

		} catch (TurnusException e) {
			e.printStackTrace();
		}
	}

	private void network() {
		emitter.emit("digraph \"%s\" {", network.getName());
		emitter.increaseIndentation();

		emitter.emit("node [shape=none];");
		emitter.emit("rankdir=LR;");

		// -- Actors
		for (Actor actor : network.getActors()) {
			instance(actor);
		}

		// -- Connections
		for (Buffer buffer : network.getBuffers()) {
			connection(buffer);
		}

		emitter.decreaseIndentation();
		emitter.emit("}");
	}

	private void instance(Actor actor) {
		emitter.emit("%s [label=<", actor.getName());
		emitter.increaseIndentation();

		emitter.emit("<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
		instanceColor(actor.getName());

		emitter.emit("<tr><td>");
		emitter.increaseIndentation();
		emitter.emit("<table border=\"1\" cellborder=\"0\" cellspacing=\"0\">");
		emitter.increaseIndentation();
		emitter.emit("<tr><td colspan=\"2\"><font point-size=\"15\">[%s]</font></td></tr>",
				actor.getActorClass().getName());

		int rows = actor.getInputPorts().size() > actor.getOutputPorts().size() ? actor.getInputPorts().size()
				: actor.getOutputPorts().size();

		// -- Ports
		for (int i = 0; i < rows; i++) {
			String in = i < actor.getInputPorts().size() ? actor.getInputPorts().get(i).getName() : "";
			String out = i < actor.getOutputPorts().size() ? actor.getOutputPorts().get(i).getName() : "";
			emitter.emit(
					"<tr><td align=\"left\" port=\"%s\"> %1$s </td><td align=\"right\" port=\"%s\"> <font point-size=\"15\"> %2$s </font> </td></tr>",
					in, out);
		}

		emitter.decreaseIndentation();
		emitter.emit("</table>");
		emitter.decreaseIndentation();
		emitter.emit("</td></tr>");

		emitter.emit("</table>>];");
		emitter.decreaseIndentation();

	}

	protected void instanceColor(String actorName) {
		emitter.emit("<tr><td bgcolor=\"black\"><font point-size=\"30\" color=\"#ffffff\"> %s </font></td></tr>",
				actorName);
	}

	private void connection(Buffer buffer) {
		String srcInstanceName = buffer.getSource().getOwner().getName();
		String tgtInstanceName = buffer.getTarget().getOwner().getName();

		String srcPort = buffer.getSource().getName();
		String srcTgt = buffer.getTarget().getName();

		// emitter.emit("%s:e -> %s:w [color=\"%s\", label=\"sz=%d\"];", source, target,
		// encodeColor(hashColor(buffer)), connectionBufferSize(buffer));
		connectionColor(hashColor(buffer), srcInstanceName, srcPort, tgtInstanceName, srcTgt);

	}

	protected void connectionColor(Color color, String source, String srcPort, String target, String srcTgt) {
		emitter.emit("%s:%s:e -> %s:%s:w [color=\"%s\"];", source, srcPort, target, srcTgt, encodeColor(color));
	}

	/**
	 * Get an RGB color from object hash code
	 *
	 * @param value
	 * @return
	 */
	protected Color hashColor(Object value) {
		if (value == null) {
			return Color.WHITE.darker();
		} else {
			int r = 0xff - (Math.abs(1 + value.hashCode()) % 0xce);
			int g = 0xff - (Math.abs(1 + value.hashCode()) % 0xdd);
			int b = 0xff - (Math.abs(1 + value.hashCode()) % 0xec);
			return new Color(r, g, b);
		}
	}

	/**
	 * hex Color string in the format #rrggbb.
	 * 
	 * @param color
	 * @return
	 */
	protected String encodeColor(Color color) {
		return String.format("#%06x", color.getRGB() & 0xffffff);

	}

}
