/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classinfo;

/**
 *
 * @author Nathan
 */
public interface Access {
    public static final int
        ACC_PUBLIC = 1, //cfim
        ACC_PRIVATE = 2, //fim
        ACC_PROTECTED = 4, //fim
        ACC_STATIC = 8, //fim
        ACC_FINAL = 0x10, //fim
        ACC_SUPER = 0x20, //classes
        ACC_SYNCHRONIZED = 0x20, //methods
        ACC_VOLATILE = 0x40, //fields
        ACC_BRIDGE = 0x40, //methods
        ACC_TRANSIENT = 0x80, //fields
        ACC_VARARGS = 0x80, //methods
        ACC_NATIVE = 0x100, //m
        ACC_INTERFACE = 0x200, //ci
        ACC_ABSTRACT = 0x400, //cim
        ACC_STRICT = 0x800, //m
        ACC_SYNTHETIC = 0x1000, //cfim
        ACC_ANNOTATION = 0x2000, //ci
        ACC_ENUM = 0x4000; //cfi
}
