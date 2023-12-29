
package Entity;

import hospital.Tools;
import javax.swing.JTable;

public class pharmacy implements mainData {
    String d_code;
    String d_type;
    String d_name;
    String d_id;

    public String getD_code() {
        return d_code;
    }

    public void setD_code(String d_code) {
        this.d_code = d_code;
    }

    public String getD_type() {
        return d_type;
    }

    public void setD_type(String d_type) {
        this.d_type = d_type;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    @Override
    public void add() {
        String insert="insert into pharmacy values("
                +d_code+","
                +"'"+ d_type+"',"
                +"'"+d_name+"',"
                +"'"+d_id+"')";
        boolean isAdd=db.Go.runNonQuery(insert);
        if(isAdd){
            Tools.msgBox("prescription is added");
        }
    }

    @Override
    public void update() {
        String update="update pharmacy set"
                +"d_type= '"+d_type+"',"
                +"d_name='"+d_name+"',"
                +"d_id='"+d_id+"'"
                +"where d_code="+d_code;
        boolean isUpdate=db.Go.runNonQuery(update);
        if(isUpdate){
            Tools.msgBox("prescription is updated");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.Go.getAutoNumber("pharmacy", "d_code");
    }

    @Override
    public void getAllRows(JTable table) {
        db.Go.fillToJTable("pharmacy_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select="select * from pharmacy_data "
                +"where d_code="+d_code;
        db.Go.fillToJTable(select, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.Go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String select="select d_code from pharmacy"
                +"where d_name='"+name+"'";
        String strVal=(String)db.Go.getTableData(select).Items[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String select="select d_name from pharmacy"
                +"where d_code="+value;
        String strName=(String)db.Go.getTableData(select).Items[0][0];
        return strName;
    }

    @Override
    public void delet() {
        String delete="delete from pharmacy "
                +"where d_code="+d_code;
        boolean isDelete=db.Go.runNonQuery(delete);
        if(isDelete){
            Tools.msgBox("prescription is deleted");
        }
    }
    
    
}
