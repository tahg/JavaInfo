/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class BranchZero extends Instruction {

    int type, delta;
    BranchZero(int offset, int type, int delta) {
        super(offset);
        this.type = type;
        this.delta = delta;
    }

}
