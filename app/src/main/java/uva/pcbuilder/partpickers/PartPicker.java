package uva.pcbuilder.partpickers;

import android.content.Context;

import java.util.List;

import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;

/**
 * Created by peuso on 23/09/2016.
 */

public class PartPicker {

    private DbHelper dbHelper;

    public PartPicker(Context context) {
        dbHelper = new DbHelper(context);
    }

    public Motherboard getMobo(float valorMaximo) {
        Motherboard motherboard = null;
        // Eh preciso passar o valorMaximo calculado de
        // uma placa mae, para que o banco retorne apenas
        // as que tenham valor menor que o calculado
        // para o orcamento
        // * Alterar metodo do banco para receber o orcamento
        List<Motherboard> mobos = dbHelper.getAllMotherboards();

        // Varrer a lista de placas maes atras da melhor entre as
        // que estao dentro do orcamento

        return motherboard;
    }

    public Processor getCpu(float valorMaximo, String socket) {
        Processor processor = null;
        // consulta o banco e retorna a lista de processadores dentro do orcamento

        // processa essa lista atras do melhor que encaixe na placa mae

        return processor;
    }

    public OpticalDiskDriver getOpticalDiscDriver(float valorMaximo) {
        OpticalDiskDriver opticalDiskDriver = null;
        // acessa banco e processa lista atras do melhor dentro do orcamento
        return opticalDiskDriver;
    }

    public Case getPcCase(float valorMaximo) {
        Case pcCase = null;
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return pcCase;
    }

    public List<MainMemory> getRamSticks(float valorMaximo, String tipoMemoria) {
        List<MainMemory> sticks = null;
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return sticks;
    }

    public List<VideoGraphicsAdapter> getGpus(float valorMaximo) {
        List<VideoGraphicsAdapter> gpus = null;
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return gpus;
    }

    public List<Storage> getStorageUnits(float valorMaximo) {
        List<Storage> units = null;
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return units;
    }
}
