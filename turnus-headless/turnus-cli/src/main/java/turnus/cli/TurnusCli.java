/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 */
package turnus.cli;

import java.util.ServiceLoader;
import turnus.cli.analysis.partitioning.PartitioningAlgorithmCli;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import turnus.cli.analysis.ImpactAnalysisCommand;
import turnus.cli.analysis.CriticalPathCommand;
import turnus.cli.analysis.BufferAnalysisCommand;
import turnus.cli.analysis.PartitioningCommand;
import turnus.cli.analysis.SimulationCommand;
import turnus.model.ModelsRegister;

/**
 * Main entry point for Turnus command-line interface.
 * 
 * @author Simone Casale-Brunet
 */
@Command(
    name = "turnus",
    description = "Turnus Dataflow Analysis Toolkit",
    version = "Turnus 1.0.0-SNAPSHOT",
    mixinStandardHelpOptions = true,
    subcommands = {
        HelpCommand.class,
        ImpactAnalysisCommand.class,
        CriticalPathCommand.class,
        BufferAnalysisCommand.class,
        PartitioningCommand.class,
        SimulationCommand.class
    }
)
public class TurnusCli implements Runnable {

    public static void main(String[] args) {
        // Initialize EMF models
        ModelsRegister.init();
        
        CommandLine cmd = new CommandLine(new TurnusCli());
        
        // Dynamically register partitioning algorithms
        CommandLine partitionCmd = cmd.getSubcommands().get("partition");
        if (partitionCmd != null) {
            ServiceLoader<PartitioningAlgorithmCli> loader = ServiceLoader.load(PartitioningAlgorithmCli.class);
            for (PartitioningAlgorithmCli algo : loader) {
                partitionCmd.addSubcommand(algo);
            }
        }
        
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        // If no subcommand specified, show help
        CommandLine.usage(this, System.out);
    }
}
