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
public abstract class CPBase {
    public static final int
        CONSTANT_Utf8 = 1,
        CONSTANT_Integer = 3,
        CONSTANT_Float = 4,
        CONSTANT_Long = 5,
        CONSTANT_Double = 6,
        CONSTANT_Class = 7,
        CONSTANT_String = 8,
        CONSTANT_Fieldref = 9,
        CONSTANT_Methodref = 10,
        CONSTANT_InterfaceMethodRef = 11,
        CONSTANT_NameAndType = 12;
    abstract public int getType();
    abstract public boolean verify();
    public ConstantPool owner;
    CPBase(ConstantPool cp) {
        owner = cp;
    }
    public static CPBase read(ConstantPool cp, DataInputStream dis) {
        try {
            int type = dis.readByte();
//            System.err.println("Found a constant of type: " + type);
            switch(type) {
                case 1: return new CPUtf8(cp, dis);
                case 3: return new CPInteger(cp, dis);
                case 4: return new CPFloat(cp, dis);
                case 5: return new CPLong(cp, dis);
                case 6: return new CPDouble(cp, dis);
                case 7: return new CPClass(cp, dis);
                case 8: return new CPString(cp, dis);
                case 9: return new CPFieldRef(cp, dis);
                case 10: return new CPMethodRef(cp, dis);
                case 11: return new CPInterfaceMethodRef(cp, dis);
                case 12: return new CPNameAndType(cp, dis);
            }
        } catch (IOException ex) {
        }
        return null;
    }
}
