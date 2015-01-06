package orderManagementID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Cars, String> {

    public Cars findById(String Id);
    //public List<Customer> findByLastName(String lastName);

}
