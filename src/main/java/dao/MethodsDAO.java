package dao;

import java.util.List;

import pojos.Method;
import pojos.TranslatedMethod;

public interface MethodsDAO {

	public int insertMethod(Method method) throws Exception;

	public int insertTranslatedMethod(TranslatedMethod tMethod) throws Exception;

	public int deleteMethod(Method method) throws Exception;

	public int deleteTranslatedMethod(TranslatedMethod tMethod) throws Exception;

	public List<Method> findAllMethods() throws Exception;

	public List<TranslatedMethod> findGrMethods() throws Exception;

	public List<TranslatedMethod> findEnMethods() throws Exception;

}
