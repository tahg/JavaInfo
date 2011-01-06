/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class LoadConstant extends Instruction {
    Object constant;

    public LoadConstant(int offset, Object constant) {
        super(offset);
        this.constant = constant;
    }    
}
