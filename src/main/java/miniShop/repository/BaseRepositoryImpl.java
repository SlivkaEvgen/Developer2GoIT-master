//package miniShop.repository;
//
//import miniShop.model.BaseModel;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class BaseRepositoryImpl<T extends BaseModel<ID>,ID> {
//
//    private Map<ID,T> repositiry = new ConcurrentHashMap<>();
//
//    public T get(ID id){
//        return (T) this.repositiry.get(id);
//    }
//}
