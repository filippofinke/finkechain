package ch.filippofinke.finkechain;

import ch.filippofinke.vm.OpCode;
import ch.filippofinke.vm.VirtualMachine;

public class App {
    public static void main(String[] args) {

        // a = 1
        // b = 1
        // if(a == b) return
        // a = 2
        // b = 4
        // return a * b
        byte[] code = {
                OpCode.PUSH, 1,
                OpCode.PUSH, 2,
                OpCode.EQ,
                OpCode.JUMP_IF, 12,
                OpCode.PUSH, 2,
                OpCode.PUSH, 4,
                OpCode.MUL,
                OpCode.STOP
        };

        VirtualMachine vm = new VirtualMachine(code);
        Byte result = vm.run();
        System.out.println("Result: " + result);

    }
}
