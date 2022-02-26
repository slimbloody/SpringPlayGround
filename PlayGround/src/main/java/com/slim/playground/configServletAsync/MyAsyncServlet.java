package com.slim.playground.configServletAsync;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(value = "/async", asyncSupported = true)
@Slf4j
public class MyAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        // asyncContext.setTimeout(1);

        log.info("main start: " + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
        asyncContext.start(() -> {
            try {
                log.info("thread sleep start" + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
                Thread.sleep(2);
                log.info("thread sleep end" + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ServletResponse response = asyncContext.getResponse();
        response.getWriter().write("hello async");
        log.info("main end: " + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
    }
}
