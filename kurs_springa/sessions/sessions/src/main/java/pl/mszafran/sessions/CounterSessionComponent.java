package pl.mszafran.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS )
class CounterSessionComponent {
    private Integer counter;

    CounterSessionComponent(){
        this.counter = 0;
    }

    void count(){
        counter++;
    }

    public Integer getCounter(){
        return counter;
    }
}
