package turnus.analysis.ui.communication;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * Linear Communication Weight menu UI Handler
 * 
 * @author Endri Bezati
 */
public class LinearCommunicationWeightHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		LinearCommunicationWeightWizard wizard = new LinearCommunicationWeightWizard();
		return new WizardDialog(window.getShell(), wizard).open();
		
	}

}
