/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

/**
 *
 * @author Nathan
 */
public class Inc extends Instruction {

    int index, delta;

    public Inc(int offset, int index, int delta) {
        super(offset);
        this.index = index;
        this.delta = delta;
    }
}
