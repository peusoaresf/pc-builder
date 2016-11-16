package uva.pcbuilder.partpickers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.VgaFuzzySystem;

/**
 * Created by peuso on 22/09/2016.
 */
public class PcBuilder {

    private PartPicker partPicker;

    public PcBuilder(Context context) {
        partPicker = new PartPicker(context);
    }

    public Computer buildComputer(float budget) {

        Computer computer = new Computer();

//        Motherboard mobo;
//        Processor cpu;
//        OpticalDiskDriver opticalDiskDriver;
//        Case pcCase;
//        List<MainMemory> ramSticks = new ArrayList<>();
        List<VideoGraphicsAdapter> gpus = new ArrayList<>();
//        List<Storage> storageUnits = new ArrayList<>();
//        Psu psu;
//
//        MotherboardFuzzySystem motherboardFuzzySystem = new MotherboardFuzzySystem();
//        mobo = partPicker.getMobo(motherboardFuzzySystem.calcularValorMaximo(budget));
//
//        ProcessorFuzzySystem processorFuzzySystem = new ProcessorFuzzySystem();
//        cpu = partPicker.getCpu(processorFuzzySystem.calcularValorMaximo(budget), mobo.getCpuSocket());
//
//        OpticalDiscDriverFuzzySystem opticalDiscDriverFuzzySystem = new OpticalDiscDriverFuzzySystem();
//        opticalDiskDriver = partPicker.getOpticalDiscDriver(opticalDiscDriverFuzzySystem.calcularValorMaximo(budget));
//
//        CaseFuzzySystem caseFuzzySystem = new CaseFuzzySystem();
//        pcCase = partPicker.getPcCase(caseFuzzySystem.calcularValorMaximo(budget));
//
//        MainMemoryFuzzySystem mainMemoryFuzzySystem = new MainMemoryFuzzySystem();
//        ramSticks.addAll(partPicker.getRamSticks(mainMemoryFuzzySystem.calcularValorMaximo(budget)));
//
        VgaFuzzySystem vgaFuzzySystem = new VgaFuzzySystem();
        gpus.addAll(partPicker.getGpus(vgaFuzzySystem.calcularValorMaximo(budget)));
//
//        StorageFuzzySystem storageFuzzySystem = new StorageFuzzySystem();
//        storageUnits.addAll(partPicker.getStorageUnits(storageFuzzySystem.calcularValorMaximo(budget)));
//
//        computer.setMotherboard(mobo);
//        computer.setProcessor(cpu);
//        computer.setOpticalDiscDriver(opticalDiskDriver);
//        computer.setCase(pcCase);
//        computer.setRamSticks(ramSticks);
        computer.setGpus(gpus);
//        computer.setStorageUnits(storageUnits);
//
//        computer.setPsu(partPicker.getPsu(computer, budget));

        return computer;
    }
}
