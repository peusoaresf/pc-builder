package uva.pcbuilder.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Computer {

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
}
