package rss.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rss.springframework.spring5webapp.models.Author;
import rss.springframework.spring5webapp.models.Book;
import rss.springframework.spring5webapp.models.Publisher;
import rss.springframework.spring5webapp.repositories.AuthorRepository;
import rss.springframework.spring5webapp.repositories.BookRepository;
import rss.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Blue");
        publisherRepository.save(publisher);

        Author babs = new Author("Baba", "Ode");
        Book ddd = new Book("Domain Driven Desiign", "1234", publisher);
        babs.getBooks().add(ddd);

        authorRepository.save(babs);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE Developement without EJB", "23444", publisher);
        rob.getBooks().add(ddd);

        authorRepository.save(rob);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
