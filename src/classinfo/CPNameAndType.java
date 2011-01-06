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
public class CPNameAndType extends CPBase {
    int name_index;
    int descriptor_index;

    public CPNameAndType(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        name_index = dis.readUnsignedShort();
        descriptor_index = dis.readUnsignedShort();
    }

    @Override
    public int getType() {
        return 12;
    }

    @Override
    public boolean verify() {
        return owner.getEntry(name_index) instanceof CPUtf8 &&
                owner.getEntry(descriptor_index) instanceof CPUtf8;
        
    }
    
}
