package miniShop.repository;

import miniShop.model.BaseModel;

import java.util.Optional;

public interface Store<E extends BaseModel<ID>,ID> {

    Optional<E> getById(ID id);

}
