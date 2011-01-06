/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Nathan
 */
public class ClassFile implements Access {
    
    int magic, major_version, minor_version;
    ConstantPool constant_pool;
    int access_flags, this_class, super_class;
    private int[] interfaces;
    private FieldInfo[] fields;
    private MethodInfo[] methods;
    private AttributeInfo[] attributes;

    public ClassFile(InputStream inputStream) {
        try {
            DataInputStream dis = new DataInputStream(inputStream);
            magic = dis.readInt();
            major_version = dis.readUnsignedShort();
            minor_version = dis.readUnsignedShort();
            constant_pool = new ConstantPool();
            constant_pool.read(dis);
            access_flags = dis.readUnsignedShort();
            this_class = dis.readUnsignedShort();
            super_class = dis.readUnsignedShort();
            {
                int count = dis.readUnsignedShort();
                interfaces = new int[count];
                for(int i = 0; i < count; i++) {
                    interfaces[i] = dis.readUnsignedShort();
                }
            }
            {
                int count = dis.readUnsignedShort();
                fields = new FieldInfo[count];
                for(int i = 0; i < count; i++) {
                    fields[i] = new FieldInfo(constant_pool, dis);
                }
            }
            {
                int count = dis.readUnsignedShort();
                methods = new MethodInfo[count];
                for(int i = 0; i < count; i++) {
                    methods[i] = new MethodInfo(constant_pool, dis);
                }
            }
            {
                int count = dis.readUnsignedShort();
                attributes = new AttributeInfo[count];
                for(int i = 0; i < count; i++) {
                    attributes[i] = AttributeInfo.read(constant_pool, dis);
                }
            }
        } catch (IOException ex) {
        }
        
    }

    /**
     * @return the interfaces
     */
    public int[] getInterfaces() {
        return interfaces;
    }

    /**
     * @return the fields
     */
    public FieldInfo[] getFields() {
        return fields;
    }

    /**
     * @return the methods
     */
    public MethodInfo[] getMethods() {
        return methods;
    }

    /**
     * @return the attributes
     */
    public AttributeInfo[] getAttributes() {
        return attributes;
    }
}
