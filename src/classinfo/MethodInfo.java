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
public class MethodInfo {
    int access_flags, name_index, descriptor_index;
    AttributeInfo[] attributes;
    ConstantPool pool;
    public MethodInfo(ConstantPool cp, DataInputStream dis) {
        pool = cp;
        try {
            access_flags = dis.readUnsignedShort();
            name_index = dis.readUnsignedShort();
            descriptor_index = dis.readUnsignedShort();
            int count = dis.readUnsignedShort();
            attributes = new AttributeInfo[count];
            for(int i = 0; i < count; i++) {
                attributes[i] = AttributeInfo.read(cp, dis);
            }
        } catch (IOException ex) {
        }
    }
    public byte[] getCode() {
        AttributeInfo code = AttributeInfo.find(ACode.class, attributes);
        if(code != null) return ((ACode)code).code;
        else return new byte[0];
    }
}
