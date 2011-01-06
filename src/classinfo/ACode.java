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
public class ACode extends AttributeInfo {

    int max_stack;
    int max_locals;
    byte[] code;
    ExceptionTableEntry[] exception_table;
    AttributeInfo[] attributes;

    public ACode(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        if (length < 8) {
            throw new IOException();
        }
        max_stack = dis.readUnsignedShort();
        max_locals = dis.readUnsignedShort();
        int code_length = dis.readInt();
        length -= 8;
        if (length < code_length) {
            throw new IOException();
        }
        code = new byte[code_length];
        while (code_length > 0) {
            code_length -= dis.read(code, code.length - code_length, code_length);
        }
        {
            int count = dis.readUnsignedShort();
            exception_table = new ExceptionTableEntry[count];
            for (int i = 0; i < count; i++) {
                exception_table[i] = new ExceptionTableEntry(dis);
            }
        }
        {
            int count = dis.readUnsignedShort();
            attributes = new AttributeInfo[count];
            for (int i = 0; i < count; i++) {
                attributes[i] = AttributeInfo.read(cp, dis);
            }
        }
    }
}
