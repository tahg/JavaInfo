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
public class AttributeInfo {

    int attribute_name_index;
    ConstantPool pool;

    AttributeInfo(ConstantPool cp, int ani) {
        attribute_name_index = ani;
        pool = cp;
    }

    AttributeInfo(ConstantPool cp, DataInputStream dis, int ani) {
        this(cp, ani);
        try {
            dis.skipBytes(dis.readInt());
        } catch (IOException ex) {
        }
    }
    
    

    public static AttributeInfo read(ConstantPool cp, DataInputStream dis) {
        try {
            int index = dis.readUnsignedShort();
            CPBase base = cp.getEntry(index);
            if (base instanceof CPUtf8) {
                String name = ((CPUtf8) base).bytes;
                if (name.equals("ConstantValue")) {
                    return new AConstant(cp, dis, index);
                } else if (name.equals("Code")) {
                    return new ACode(cp, dis, index);
//                } else if (name.equals("StackMapTable")) {
//                    return new AStackMap(cp, dis, index);
                } else if (name.equals("Exceptions")) {
                    return new AExceptions(cp, dis, index);
                } else if (name.equals("InnerClasses")) {
                    return new AInnerClasses(cp, dis, index);
                } else if (name.equals("EnclosingMethod")) {
                    return new AEnclosingMethod(cp, dis, index);
                } else if (name.equals("Synthetic")) {
                    return new ASynthetic(cp, dis, index);
                } else if (name.equals("Signature")) {
                    return new ASignature(cp, dis, index);
                } else if (name.equals("SourceFile")) {
                    return new ASourceFile(cp, dis, index);
                } else if (name.equals("LineNumberTable")) {
                    return new ALineNumberTable(cp, dis, index);
                } else if (name.equals("LocalVariableTable")) {
                    return new ALocalVariableTable(cp, dis, index);
                } else if (name.equals("LocalVariableTypeTable")) {
                    return new ALocalVariableTypeTable(cp, dis, index);
                } else if (name.equals("Depricated")) {
                    return new ADepricated(cp, dis, index);
//                } else if (name.equals("RuntimeVisibleAnnotations")) {
//                    return new ARuntimeVisible(cp, dis, index);
//                } else if (name.equals("RuntimeInvisibleAnnotations")) {
//                    return new ARuntimeInvisible(cp, dis, index);
//                } else if (name.equals("RuntimeVisibleParamaterAnnotations")) {
//                    return new ARuntimeVisibleParamater(cp, dis, index);
//                } else if (name.equals("RuntimeInvisibleParamaterAnnotations")) {
//                    return new ARuntimeInvisibleParamater(cp, dis, index);
//                } else if (name.equals("AnnotationDefault")) {
//                    return new AConstant(cp, dis, index);
                } else return new AttributeInfo(cp, dis, index);
            }
        } catch (IOException ex) {
        }
        return new AttributeInfo(cp, dis, 0);
    }
    
    public static AttributeInfo find(Class cls, AttributeInfo[] attribs) {
        if(attribs == null) {
            System.err.println("No attribs!");
        }
        for(AttributeInfo a : attribs) {
            if(a.getClass().equals(cls)) return a;
        }
        return null;
    }
}