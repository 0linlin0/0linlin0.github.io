package Test;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.lang.instrument.Instrumentation;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        List<VirtualMachineDescriptor> all = VirtualMachine.list();
        for (VirtualMachineDescriptor virtualMachineDescriptor : all) {
            if (virtualMachineDescriptor.displayName().contains("StartADSM")){
                VirtualMachine.attach(virtualMachineDescriptor).loadAgent("aaa");
                return;
            }
        }
    }
    public static void agentmain(String agentArgs, Instrumentation inst){

    }
    //com.adventnet.sym.adsm.common.server.admin.authentication.ADMPADAuthenticator#authenticate
}
