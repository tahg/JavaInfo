/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

/**
 *
 * @author Nathan
 */
public class InvokeVirtual extends Instruction {

    int index;

    public InvokeVirtual(int offset, int index) {
        super(offset);
        this.index = index;
    }
}
