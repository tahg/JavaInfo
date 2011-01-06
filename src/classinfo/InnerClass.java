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
public class InnerClass {

    int inner_class_info_index;
    int outer_class_info_index;
    int inner_name_index;
    int inner_class_access_flags;

    public InnerClass(DataInputStream dis) {
        try {
            inner_class_info_index = dis.readUnsignedShort();
            outer_class_info_index = dis.readUnsignedShort();
            inner_name_index = dis.readUnsignedShort();
            inner_class_access_flags = dis.readUnsignedShort();
        } catch (IOException ex) {
        }
    }
}
