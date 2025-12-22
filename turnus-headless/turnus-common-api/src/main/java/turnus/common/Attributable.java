package turnus.common;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;

public interface Attributable extends EObject {
    Map<String, Object> getAttributesMap();
    void setAttribute(String name, Object value);
    Object getAttribute(String name);
    Object removeAttribute(String name);
    boolean hasAttribute(String name);
}
