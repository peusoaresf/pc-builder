package uva.pcbuilder.dominio;

import android.provider.MediaStore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Computer implements Serializable {

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

    public void addRamStick(MainMemory stick) {
        ramSticks.add(stick);
    }

    public List<MainMemory> getRamSticks() {
        return ramSticks;
    }

    public void setGpus(List<VideoGraphicsAdapter> gpus) {
        this.gpus.addAll(gpus);
    }

    public void addGpu(VideoGraphicsAdapter gpu) {
        gpus.add(gpu);
    }

    public List<VideoGraphicsAdapter> getGpus() {
        return gpus;
    }

    public void setStorageUnits(List<Storage> units) {
        storageUnits.addAll(units);
    }

    public void addStorageUnit(Storage s) {
        storageUnits.add(s);
    }

    public List<Storage> getStorageUnits() {
        return storageUnits;
    }

    public void setHardware(Hardware hw) {
        if (hw instanceof Case)
            this.setCase((Case) hw);
        if (hw instanceof MainMemory)
            this.addRamStick((MainMemory) hw);
        if (hw instanceof  Motherboard)
            this.setMotherboard((Motherboard) hw);
        if (hw instanceof OpticalDiskDriver)
            this.setOpticalDiscDriver((OpticalDiskDriver) hw);
        if (hw instanceof Processor)
            this.setProcessor((Processor) hw);
        if (hw instanceof Psu)
            this.setPsu((Psu) hw);
        if (hw instanceof Storage)
            this.addStorageUnit((Storage) hw);
        if (hw instanceof  VideoGraphicsAdapter)
            this.addGpu((VideoGraphicsAdapter) hw);
    }

    public List<? extends Hardware> toList() {
        List<? extends Hardware> list;
        List<Hardware> aux = new ArrayList<>();
        if (this.getCase() != null)
            aux.add(this.getCase());
        if (!this.getRamSticks().isEmpty()) {
            if (this.getRamSticks().get(0) != null)
            aux.add(this.getRamSticks().get(0));
        }
        if (this.getMotherboard() != null)
            aux.add(this.getMotherboard());
        if (this.getOpticalDiskDriver() != null)
            aux.add(this.getOpticalDiskDriver());
        if (this.getProcessor() != null)
            aux.add(this.getProcessor());
        if (this.getPsu() != null)
            aux.add(this.getPsu());
        if (!this.getStorageUnits().isEmpty()) {
            if (this.getStorageUnits().get(0) != null)
                aux.add(this.getStorageUnits().get(0));
        }
        if (!this.getGpus().isEmpty()) {
            if (this.getGpus().get(0) != null)
            aux.add(this.getGpus().get(0));
        }
        list = aux;
        return list;
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
