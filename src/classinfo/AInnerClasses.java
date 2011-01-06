/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classinfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Nathan
 */
public class AInnerClasses extends AttributeInfo {
    InnerClass[] classes;
    public AInnerClasses(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        int count = dis.readUnsignedShort();
        classes = new InnerClass[count];
        for(int i = 0; i < count; i++) {
            classes[i] = new InnerClass(dis);
        }
    }
}
