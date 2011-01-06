/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nathan
 */
public class ConstantPool {

    CPBase[] pool;

    public CPBase getEntry(int index) {
        if (index > 0 && index < pool.length) {
            return pool[index];
        }
        return null;
    }

    public boolean read(DataInputStream dis) {
        try {
            int count = dis.readUnsignedShort();
            pool = new CPBase[count];
            for (int i = 1; i < count; i++) {
                pool[i] = CPBase.read(this, dis);
                if (pool[i] instanceof CPLong || pool[i] instanceof CPDouble) {
                    i++;
                }
            }
            for (int i = 1; i < count; i++) {
                if (pool[i] != null && !pool[i].verify()) {
                    return false;
                }
            }
        } catch (IOException ex) {
        }
        return true;
    }
}
