package Entity;

import hospital.Tools;
import javax.swing.JTable;

public class patient implements mainData {
    String p_number;
    String p_name;
    String p_address;
    String p_gender;
    int p_age;

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public int getP_age() {
        return p_age;
    }

    public void setP_age(int p_age) {
        this.p_age = p_age;
    }

    @Override
    public void add() {
        String insert="insert into patient values("
                +p_number+","
                +"'"+ p_name+"',"
                +"'"+p_address+"',"
                +"'"+p_gender+"',"
                +"'"+p_age+"')";
        boolean isAdd=db.Go.runNonQuery(insert);
        if(isAdd){
            Tools.msgBox("patient is added");
        }
    }

    @Override
    public void update() {
        String update = "update patient set "
                + "p_name='" + p_name + "',"
                + "p_address='" + p_address + "', "
                + "p_gender='" + p_gender + "' ,"
                + "p_age='" + p_age + "' "
                + " where p_number=" + p_number;
        boolean isUpdate = db.Go.runNonQuery(update);
        if(isUpdate){
            Tools.msgBox("patient Is Updated");
        }
    }

    @Override
    public void delet() {
        String delete = "delete from patient"
                + " where p_number=" + p_number;
        boolean isDelete = db.Go.runNonQuery(delete);
        if(isDelete){
            Tools.msgBox("patient Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.Go.getAutoNumber("patient", "p_number");

    }

    @Override
    public void getAllRows(JTable table) {
        db.Go.fillToJTable("patientdata", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select = "select * from patientdata "
                + " where p_number=" + p_number;
        db.Go.fillToJTable(select, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.Go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String select = "select p_number from patient"
                + " where p_name='" + name + "'";
        String strVal = (String)db.Go.getTableData(select).Items[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String select = "select p_name from patient"
                + " where p_number=" + value;
        String strName = (String)db.Go.getTableData(select).Items[0][0];
        return strName;
    }
    
}
