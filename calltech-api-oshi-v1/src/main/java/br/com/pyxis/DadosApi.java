package br.com.pyxis;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.List;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.util.FormatUtil;

public class DadosApi {

    public static void main(String[] args) {
        //Instancia o Objeto que contém as informações do Sistema
        SystemInfo si = new SystemInfo();

        //Utiliza o Objeto "si" para pegar informações sobre o hardware
        HardwareAbstractionLayer hal = si.getHardware();

        //Utiliza o Objeto "si" para pegar informações sobre o sistema operacional
        OperatingSystem os = si.getOperatingSystem();

        
        System.out.println(hal.getSensors().toString());
        
        //Metódo para pegar informações dos Discos
        List<HWDiskStore> listaDisco = hal.getDiskStores(); 
        for (HWDiskStore disco : listaDisco) { 
            System.out.println("\nUnidades de disco padr�o\n");
            System.out.format("Nome: %s \nTamanho total: %s \nEscrita: %s \nDispon�vel: %s\n", 
                    disco.getName(), 
                    FormatUtil.formatValue(disco.getSize(), "B"), 
                    FormatUtil.formatBytes(disco.getWriteBytes()),
                    FormatUtil.formatValue((disco.getSize() - disco.getWriteBytes()), "B"
            ));
            
            List<HWPartition> particoes = disco.getPartitions();
            for (HWPartition partition : particoes) {
                
                System.out.format("\nParti��o #%d: %s \nTamanho: %s\n", 
                    partition.getMinor(),
                    partition.getMountPoint(), 
                    FormatUtil.formatValue(partition.getSize(), "B")
                );
            }
        }

        System.out.println("\nCPU");
        //Metódo para pegar informações da CPU
        System.out.println(hal.getProcessor());

        System.out.println("\nMemória");
        //Metódo para pegar informações de Memória
        System.out.println(hal.getMemory());

        System.out.println("\nProcessos");
        //Metódo para pegar uma Lista de Processos
        List<OSProcess> a = os.getProcesses();

        //Listando cada processo individualmente
        for (OSProcess process: a) {
            System.out.println(process+"\n");
        }
    }
}
