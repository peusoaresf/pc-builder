package uva.pcbuilder.partpickers;

import android.content.Context;

import java.util.List;

import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.Computador;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiscDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;
import uva.pcbuilder.expertsystems.pcCase.ExpertSystemCase;
import uva.pcbuilder.expertsystems.opticaldiskdrive.ExpertSystemOpticalDiskDrive;
import uva.pcbuilder.expertsystems.ram.ExpertSystemRam;
import uva.pcbuilder.expertsystems.storage.ExpertSystemStorage;
import uva.pcbuilder.fuzzysystems.cpu.FuzzySystemCpu;
import uva.pcbuilder.fuzzysystems.mobo.FuzzySystemMobo;
import uva.pcbuilder.fuzzysystems.vga.FuzzySystemVGA;

/**
 * Created by peuso on 22/09/2016.
 */
public class PcBuilder {

    private DbHelper dbHelper;

    public PcBuilder(Context context) {
        dbHelper = new DbHelper(context);
    }

    public Computador montarComputador(float orcamento) {
        Computador computador = new Computador();

        float valorMaximoMobo;
        float valorMaximoCpu;
        float valorMaximoOpticalDiskDrive;
        float valorMaximoCase;
        float valorMaximoRam;
        float valorMaximoVga;
        float valorMaximoStorage;

        Motherboard mobo;
        Processor cpu;
        OpticalDiscDriver opticalDiscDriver;
        Case pcCase;
        Psu psu;
        List<MainMemory> ramSticks;
        List<VideoGraphicsAdapter> gpus;
        List<Storage> storageUnits;

        FuzzySystemVGA fuzzySystemVGA = new FuzzySystemVGA();
        valorMaximoVga = fuzzySystemVGA.calcularValorMaximo(orcamento);

        FuzzySystemCpu fuzzySystemCpu = new FuzzySystemCpu();
        valorMaximoCpu = fuzzySystemCpu.calcularValorMaximo(orcamento);

        FuzzySystemMobo fuzzySystemMobo = new FuzzySystemMobo();
        valorMaximoMobo = fuzzySystemMobo.calcularValorMaximo(orcamento);

        ExpertSystemStorage expertSystemStorage = new ExpertSystemStorage();
        valorMaximoStorage = expertSystemStorage.calcularValorMaximo(orcamento);

        ExpertSystemOpticalDiskDrive expertSystemOpticalDiskDrive = new ExpertSystemOpticalDiskDrive();
        valorMaximoOpticalDiskDrive = expertSystemOpticalDiskDrive.calcularValorMaximo(orcamento);

        ExpertSystemRam expertSystemRam = new ExpertSystemRam();
        valorMaximoRam = expertSystemRam.calcularValorMaximo(orcamento);

        ExpertSystemCase expertSystemCase = new ExpertSystemCase();
        valorMaximoCase = expertSystemCase.calcularValorMaximo(orcamento);

        mobo = dbHelper.getMobo(valorMaximoMobo);
        cpu = dbHelper.getCpu(valorMaximoCpu);
        opticalDiscDriver = dbHelper.getOpticalDiscDriver(valorMaximoOpticalDiskDrive);
        pcCase = dbHelper.getPcCase(valorMaximoCase);
        ramSticks = dbHelper.getRamSticks(valorMaximoRam);
        gpus = dbHelper.getGpus(valorMaximoVga);
        storageUnits = dbHelper.getStorageUnits(valorMaximoStorage);

        computador.addMotherboard(mobo);
        computador.addProcessor(cpu);
        computador.addOpticalDiscDriver(opticalDiscDriver);
        computador.addPcCase(pcCase);
        computador.addRamSticks(ramSticks);
        computador.addGpus(gpus);
        computador.addStorageUnits(storageUnits);

        PsuChooser psuChooser = new PsuChooser();
        psu = psuChooser.pickRecommendedPsu(computador);

        computador.addPsu(psu);

        return computador;
    }
}
