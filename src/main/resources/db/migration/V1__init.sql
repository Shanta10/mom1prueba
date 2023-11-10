CREATE TABLE IF NOT EXISTS conference (
    id SERIAL,
    tittleconf VARCHAR(255) NOT NULL,
    descriptionconf VARCHAR(255) NOT NULL,
    cityconf VARCHAR(20) NOT NULL,
    totalassisconf INT NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS assistant (
    id SERIAL,
    nameassistant VARCHAR(255) NOT NULL,
    roleassistant VARCHAR(255) NOT NULL,
    ageassistant INT NOT NULL,
    conference_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (conference_id) REFERENCES conference(id)
    );
