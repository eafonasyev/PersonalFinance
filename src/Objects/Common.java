package Objects;

import saveLoad.SaveData;

abstract public  class Common {
     public void postEdit(SaveData sd){};
     public void postAdd(SaveData sd){};
     public void postRemove(SaveData sd){};

    public String getValueForComboBox(){
        return null;
    }

}
