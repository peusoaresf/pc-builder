package uva.pcbuilder.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Computador {
    private Motherboard mobo;
    private Processor cpu;
    private OpticalDiscDriver opticalDiscDriver;
    private Case pcCase;
    private Psu psu;
    private List<MainMemory> ramSticks;
    private List<VideoGraphicsAdapter> gpus;
    private List<Storage> storageUnits;

    public Computador() {
        ramSticks = new ArrayList<>();
        gpus = new ArrayList<>();
        storageUnits = new ArrayList<>();
    }

    public void addMotherboard(Motherboard m) {
        mobo = m;
    }

    public void addProcessor(Processor p) {
        cpu = p;
    }

    public void addOpticalDiscDriver(OpticalDiscDriver odd) {
        opticalDiscDriver = odd;
    }

    public void addPcCase(Case c) {
        pcCase = c;
    }

    public void addPsu(Psu p) {
        psu = p;
    }

    public void addRamSticks(List<MainMemory> mms) {
        ramSticks.addAll(mms);
    }


    public void addGpus(List<VideoGraphicsAdapter> vgas) {
        gpus.addAll(gpus);
    }

    public void addStorageUnits(List<Storage> s) {
        storageUnits.addAll(s);
    }
}
