package area;

import java.util.Objects;

public class FertileField extends Ground{

    public FertileField() {
        this.state = "Gotowe do wysiewu";
    }

    public void changeState(){
        if(Objects.equals(this.state, "Rośnie zboże")){
            this.state = "Gotowe do wysiewu";
        } else {
            this.state = "Rośnie zboże";
        }
    }


}
