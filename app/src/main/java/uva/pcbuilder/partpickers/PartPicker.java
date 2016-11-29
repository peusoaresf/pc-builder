package uva.pcbuilder.partpickers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;

/**
 * Created by peuso on 23/09/2016.
 */

public class PartPicker {

    private DbHelper dbHelper;
    private PsuPicker psuPicker;

    public PartPicker(Context context) {
        dbHelper = new DbHelper(context);
        psuPicker = new PsuPicker();
    }
    /*
     * Eh preciso ajustar os metodos no banco para retornar a lista
     * de pecas com o valor menor  que o maximo, para que o partpicker tenha a inteligencia
     * de decidir qual retornar ou a quantidade de tal peca por no pc.
     * CLASSE NÃO ESTÁ COMPLETADA, MÉTODOS ESTÃO SIMPLISTAS PARA DEMONSTRAR
     * FUNCIONALIDADE DO APP.
     */
    public Motherboard getMobo(float valorMaximo) {
        Motherboard motherboard = null;
        // Eh preciso passar o valorMaximo calculado de
        // uma placa mae, para que o banco retorne apenas
        // as que tenham valor menor que o calculado
        // para o orcamento
        // * Alterar metodo do banco para receber o orcamento
        motherboard = dbHelper.getMotherboard(valorMaximo);

        // Varrer a lista de placas maes atras da melhor entre as
        // que estao dentro do orcamento

        return motherboard;
    }

    public Processor getCpu(float valorMaximo, Motherboard m) {
        Processor processor = null;
        // consulta o banco e retorna a lista de processadores dentro do orcamento

        processor = dbHelper.getProcessor(valorMaximo, m.getCpuSocket());

        // processa essa lista atras do melhor que encaixe na placa mae

        return processor;
    }

    public OpticalDiskDriver getOpticalDiscDriver(float valorMaximo) {
        OpticalDiskDriver opticalDiskDriver = null;
        opticalDiskDriver = dbHelper.getOpticalDiskDriver(valorMaximo);
        // acessa banco e processa lista atras do melhor dentro do orcamento
        return opticalDiskDriver;
    }

    public Case getPcCase(float valorMaximo) {
        Case pcCase = null;
        pcCase = dbHelper.getCase(valorMaximo);
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return pcCase;
    }

    public List<MainMemory> getRamSticks(float valorMaximo, Motherboard m) {
        List<MainMemory> sticks = new ArrayList<>();
        sticks.add(dbHelper.getMainMemory(valorMaximo, m.getSupportedRamType()));
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return sticks;
    }

    public List<VideoGraphicsAdapter> getGpus(float valorMaximo) {
        List<VideoGraphicsAdapter> gpus = new ArrayList<>();
        gpus.add(dbHelper.getVga(valorMaximo));
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return gpus;
    }

    public List<Storage> getStorageUnits(float valorMaximo) {
        List<Storage> units = new ArrayList<>();
        units.add(dbHelper.getStorage(valorMaximo));
    // acessa banco e processa lista atras do melhor dentro do orcamento
        return units;
    }

    public Psu getPsu(Computer pc, float valorMaximo) {
        Psu psu = null;

        // Eh preciso pegar todas as PSUs ate "valorMaximo"
        // e passar como parametro para saber se algum delas eh potente para o computador.
        // Se nao for, alguma inteligencia sera feita para decidir como prosseguir sem estourar
        // o orcamento.
        List<Psu> psus = new ArrayList<>();
        psus.add(dbHelper.getPSU(valorMaximo));

        psu = psuPicker.pickRecommendedPsu(psus, pc);
        return psu;
    }
}
