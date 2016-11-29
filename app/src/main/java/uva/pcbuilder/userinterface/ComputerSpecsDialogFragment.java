package uva.pcbuilder.userinterface;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by peuso on 26/11/2016.
 */

public class ComputerSpecsDialogFragment extends DialogFragment {
    String specs;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(specs);
        return builder.create();
    }
    public void setSpecs(String s) {
        this.specs = s;
    }
    public static void showDialog(FragmentManager fm, String specs) {
        ComputerSpecsDialogFragment dialog = new ComputerSpecsDialogFragment();
        dialog.setSpecs(specs);
        dialog.show(fm, "Dialog");
    }
}
