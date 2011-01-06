/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class NewMultiRefArray extends Instruction {
    int type;
    int dimensions;
    NewMultiRefArray(int offset, int type, int dimensions) {
        super(offset);
        this.type = type;
        this.dimensions = dimensions;
    }
}
