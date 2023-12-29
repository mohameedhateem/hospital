
package hospital;

import forms.frmLogin;
import forms.frmPatient;
import forms.frmdoctor;
import forms.frmtest;


public class Hospital {

    
    public static void main(String[] args) {
        Tools.openForm(new frmLogin());
        //Tools.openForm(new frmtest());
        //Tools.openForm(new frmPatient());
       // Tools.openForm(new frmdoctor());
    }
    
}
