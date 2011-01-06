/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

/**
 *
 * @author Nathan
 */
public class StackOp extends Instruction {
    int width, mode;
    public StackOp(int offset, int width, int mode) {
        super(offset);
        this.width = width;
        this.mode = mode;
    }
}
