
package Entity;

import hospital.Tools;
import javax.swing.JTable;


public class doctor implements mainData  {
    private String d_id;
    private String d_name;
    private String number_phone;
    private String gender;
    private String p_number;

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }

    @Override
    public void add() {
        String insert="insert into doctor values("
                +d_id+","
                +"'"+ d_name+"',"
                +"'"+number_phone+"',"
                +"'"+gender+"',"
                +"'"+p_number+"')";
        boolean isAdd=db.Go.runNonQuery(insert);
        if(isAdd){
            Tools.msgBox("Doctor is added");
        }
    }

    @Override
    public void update() {
        String update = "update doctor set "
                + "d_name='" + d_name + "',"
                + "number_phone='" + number_phone + "', "
                + "gender='" + gender + "' ,"
                + "p_number='" + p_number + "' "
                + " where d_id=" + d_id;
        boolean isUpdate = db.Go.runNonQuery(update);
        if(isUpdate){
            Tools.msgBox("Doctor Is Updated");
        }
    }

    @Override
    public void delet() {
        String delete = "delete from doctor"
                + " where d_id=" + d_id;
        boolean isDelete = db.Go.runNonQuery(delete);
        if(isDelete){
            Tools.msgBox("Doctor Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.Go.getAutoNumber("doctor", "d_id");
    }

    @Override
    public void getAllRows(JTable table) {
        db.Go.fillToJTable("doctor_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select = "select * from doctor_data "
                + " where d_id=" + d_id;
        db.Go.fillToJTable(select, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.Go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String select = "select d_id from doctor"
                + " where d_name='" + name + "'";
        String strVal = (String)db.Go.getTableData(select).Items[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String select = "select d_name from doctor"
                + " where d_id=" + value;
        String strName = (String)db.Go.getTableData(select).Items[0][0];
        return strName;
    }
    
    
}
