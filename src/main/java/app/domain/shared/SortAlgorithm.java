package app.domain.shared;

import app.domain.dto.ClientDTO;

import java.util.Comparator;

public class SortAlgorithm {

    public SortAlgorithm(){}


    public static class ClientCompareByName implements Comparator<ClientDTO> {


        @Override
        public int compare(ClientDTO o1, ClientDTO o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class ClientCompareByTIN implements Comparator<ClientDTO>{

        @Override
        public int compare(ClientDTO o1, ClientDTO o2){
            Long l = o1.getTin() - o2.getTin();
            int i = l.intValue();
            return i;
        }
    }
}
