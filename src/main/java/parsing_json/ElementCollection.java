package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ElementCollection extends ArrayList<Element> {

    public Element findByAtomicNumber(int atomic_number) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            if (e.getNumber() == atomic_number) {
                return e;
            }
        }
        return null;
    }

    public Element findByName(String name) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection returnCollection = new ElementCollection();

        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            try {
                Field field = e.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                try {
                    if(field.get(e).equals(value)) {
                        returnCollection.add(e);
                    }
                } catch (IllegalAccessException e1) {
                    return returnCollection;
                }
            } catch (NoSuchFieldException e1) {
                return returnCollection;
            }
        }

        return returnCollection;
    }
}
