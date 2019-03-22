package chapter3.e16_use_inheritable_thread_local;

/**
 * @Author Nacht
 * Created on 23/03/2019
 */
public class InheritableThreadLocalUtil {
    static class InheritableThreadLocalExt extends InheritableThreadLocal<String>{
        @Override
        protected String initialValue() {
            return "普普通通的初始值";
        }
    }
    static InheritableThreadLocal<String> inheritableThreadLocalExt= new InheritableThreadLocalExt();
}
