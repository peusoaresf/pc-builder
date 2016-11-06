package uva.pcbuilder.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Computer {

    private static Computer example;

    private Motherboard mobo;
    private Processor cpu;
    private OpticalDiskDriver opticalDiskDriver;
    private Case pcCase;
    private Psu psu;
    private List<MainMemory> ramSticks;
    private List<VideoGraphicsAdapter> gpus;
    private List<Storage> storageUnits;

    public Computer() {
        ramSticks = new ArrayList<>();
        gpus = new ArrayList<>();
        storageUnits = new ArrayList<>();
    }

    public void setMotherboard(Motherboard m) {
        mobo = m;
    }

    public Motherboard getMotherboard() {
        return mobo;
    }

    public void setProcessor(Processor p) {
        cpu = p;
    }

    public Processor getProcessor() {
        return cpu;
    }

    public void setOpticalDiscDriver(OpticalDiskDriver odd) {
        opticalDiskDriver = odd;
    }

    public OpticalDiskDriver getOpticalDiskDriver() {
        return opticalDiskDriver;
    }

    public void setCase(Case c) {
        pcCase = c;
    }

    public Case getCase() {
        return pcCase;
    }

    public void setPsu(Psu p) {
        psu = p;
    }

    public Psu getPsu() {
        return psu;
    }

    public void setRamSticks(List<MainMemory> sticks) {
        ramSticks.addAll(sticks);
    }

    public List<MainMemory> getRamSticks() {
        return ramSticks;
    }

    public void setGpus(List<VideoGraphicsAdapter> gpus) {
        this.gpus.addAll(gpus);
    }

    public List<VideoGraphicsAdapter> getGpus() {
        return gpus;
    }

    public void setStorageUnits(List<Storage> units) {
        storageUnits.addAll(units);
    }

    public List<Storage> getStorageUnits() {
        return storageUnits;
    }

    public static Computer createExample() {
        if (example != null) {
            return example;
        }
        else {
            example = new Computer();
            example.setMotherboard((Motherboard) Motherboard.createExample().get(0));
            example.setProcessor((Processor) Processor.createExample().get(0));
            example.setOpticalDiscDriver((OpticalDiskDriver) OpticalDiskDriver.createExample().get(0));
            example.setCase((Case) Case.createExample().get(0));
            example.setPsu((Psu) Psu.createExample().get(0));
            List<MainMemory> e1 = new ArrayList<>();
            e1.add((MainMemory) MainMemory.createExample().get(0));
            example.setRamSticks(e1);
            List<VideoGraphicsAdapter> e2 = new ArrayList<>();
            e2.add((VideoGraphicsAdapter) VideoGraphicsAdapter.createExample().get(0));
            example.setGpus(e2);
            List<Storage> e3 = new ArrayList<>();
            e3.add((Storage) Storage.createExample().get(0));
            example.setStorageUnits(e3);
            return example;
        }
    }
}
