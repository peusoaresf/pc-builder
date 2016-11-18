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
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.CaseFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.CpuFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.MoboFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.ODDFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.PsuFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.RamFuzzySystem;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.StorageFuzzySystem;
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

        MoboFuzzySystem motherboardFuzzySystem = new MoboFuzzySystem();
        Motherboard mobo = partPicker.getMobo(motherboardFuzzySystem.calcularValorMaximo(budget));

        CpuFuzzySystem processorFuzzySystem = new CpuFuzzySystem();
        Processor cpu = null;
        if (mobo != null)
            cpu = partPicker.getCpu(processorFuzzySystem.calcularValorMaximo(budget), mobo);

        ODDFuzzySystem opticalDiscDriverFuzzySystem = new ODDFuzzySystem();
        OpticalDiskDriver opticalDiskDriver = partPicker.getOpticalDiscDriver(opticalDiscDriverFuzzySystem.calcularValorMaximo(budget));

        CaseFuzzySystem caseFuzzySystem = new CaseFuzzySystem();
        Case pcCase = partPicker.getPcCase(caseFuzzySystem.calcularValorMaximo(budget));

        List<MainMemory> ramSticks = new ArrayList<>();
        RamFuzzySystem mainMemoryFuzzySystem = new RamFuzzySystem();
        if (mobo != null)
            ramSticks.addAll(partPicker.getRamSticks(mainMemoryFuzzySystem.calcularValorMaximo(budget), mobo));

        List<VideoGraphicsAdapter> gpus = new ArrayList<>();
        VgaFuzzySystem vgaFuzzySystem = new VgaFuzzySystem();
        gpus.addAll(partPicker.getGpus(vgaFuzzySystem.calcularValorMaximo(budget)));

        List<Storage> storageUnits = new ArrayList<>();
        StorageFuzzySystem storageFuzzySystem = new StorageFuzzySystem();
        storageUnits.addAll(partPicker.getStorageUnits(storageFuzzySystem.calcularValorMaximo(budget)));

        computer.setMotherboard(mobo);
        computer.setProcessor(cpu);
        computer.setOpticalDiscDriver(opticalDiskDriver);
        computer.setCase(pcCase);
        computer.setRamSticks(ramSticks);
        computer.setGpus(gpus);
        computer.setStorageUnits(storageUnits);

        PsuFuzzySystem psuFuzzySystem = new PsuFuzzySystem();
        computer.setPsu(partPicker.getPsu(computer, psuFuzzySystem.calcularValorMaximo(budget)));

        return computer;
    }
}
