package myfirst.base;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaseService<T,ID extends Serializable> {

	//记录日志
	protected Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	protected BaseRepository<T, ID> baseRepository;
	
	/**增加/修改实体，当有id时为修改实体，没有id的时候为增加实体
	 * @param t
	 */
	public void doSave(T t){
		baseRepository.save(t);
	}
	
	/**删除实体
	 * @param t
	 */
	public void doDelete(T t){
		baseRepository.delete(t);
	}
	
	/**通过ID删除
	 * @param id
	 */
	public void doDelete(ID id){
		baseRepository.delete(id);
	}
	
	/**通过ID查找实体
	 * @param id
	 */
	public T getByIdT(ID id){
		return baseRepository.findOne(id);
	}
	
	/**查找所有的实体
	 * @param t
	 * @return
	 */
	public List<T> get(T t){
		return baseRepository.findAll();
	}
	
	/**通过多个id查找多个实体
	 * @param ids
	 */
	public List<T> get(List<ID> ids){
		return (List<T>) baseRepository.findAll( ids);
	}
	
	/**分页查找
	 * @param page
	 */
	public void get(Pageable page){
		baseRepository.findAll(page);
	}
	
	/**判断是否有存在的id
	 * @param id
	 * @return
	 */
	public boolean getIsExist(ID id){
		return baseRepository.exists(id);
	}
	


}
