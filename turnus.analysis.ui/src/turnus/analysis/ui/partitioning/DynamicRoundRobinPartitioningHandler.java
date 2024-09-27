package turnus.analysis.ui.partitioning;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * Dynamic RR Partitioning menu UI Handler
 * 
 * @author Endri Bezati
 */
public class DynamicRoundRobinPartitioningHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		DynamicRoundRobinPartitioningWizard wizard = new DynamicRoundRobinPartitioningWizard();
		return new WizardDialog(window.getShell(), wizard).open();
	}

}
