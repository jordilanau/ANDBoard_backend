DROP TABLE IF EXISTS "card_keyword";
DROP TABLE IF EXISTS "card";
DROP TABLE IF EXISTS "keyword";
DROP TABLE IF EXISTS "user_entity";
DROP TABLE IF EXISTS "icon";

-- Create Table
CREATE TABLE "icon"
(
    id         serial PRIMARY KEY,
    created_at timestamp NOT NULL DEFAULT now(),
    updated_at timestamp NOT NULL DEFAULT now(),
    category   varchar UNIQUE,
    icon_link  varchar
);

-- Create Table
CREATE TABLE "card"
(
    id          serial PRIMARY KEY,
    created_at  timestamp NOT NULL DEFAULT now(),
    updated_at  timestamp NOT NULL DEFAULT now(),
    category    varchar,
    title       varchar,
    description varchar,
    link        varchar,
    icon_id     int,
    FOREIGN KEY (icon_id) REFERENCES icon (id)
);

-- Create Table
CREATE TABLE "keyword"
(
    id         serial PRIMARY KEY,
    created_at timestamp NOT NULL DEFAULT now(),
    updated_at timestamp NOT NULL DEFAULT now(),
    value      varchar UNIQUE
);

-- Create Table
CREATE TABLE "card_keyword"
(
    card_id    INT REFERENCES "card" (id),
    keyword_id INT REFERENCES "keyword" (id),
    PRIMARY KEY (card_id, keyword_id)
);

-- Create Table
CREATE TABLE "user_entity"
(
    id         serial PRIMARY KEY,
    created_at timestamp NOT NULL DEFAULT now(),
    updated_at timestamp NOT NULL DEFAULT now(),
    email      varchar UNIQUE,
    password   varchar,
    role       varchar            DEFAULT 'USER' CHECK (role IN ('USER', 'ADMIN'))
);


-- Add Icons
INSERT INTO "icon"("category", "icon_link")
VALUES ('slack', 'https://static.surveysparrow.com/site/assets/integrations/inner/slack.png'),
       ('okta', 'https://e7.pngegg.com/pngimages/182/338/png-clipart-okta-thumbnail-tech-companies-thumbnail.png'),
       ('luna', 'https://luna.and-digital.com/prod-favicon.ico'),
       ('hdbi', 'https://herrmann.com.au/wp-content/uploads/2020/08/cropped-Registered-Logo-Mark.png'),
       ('upwave', 'https://avatars.slack-edge.com/2017-06-02/191721972594_267d0e83b349d1a8e40a_512.png'),
       ('gmail', 'https://logos-world.net/wp-content/uploads/2020/11/Gmail-Logo-700x394.png'),
       ('gcalendar',
        'https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/google-calendar-icon.png'),
       ('bridge', 'https://www.getbridge.com/wp-content/uploads/2020/10/Bridge_Logo_Vertical.png'),
       ('gdrive',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Google_Drive_logo.png/600px-Google_Drive_logo.png');

-- Add cards
INSERT INTO "card"("category", "title", "description", "link", "icon_id")
VALUES ('okta', 'Activate Okta',
        'This page is used to provide single sign on(sso) and urls for each of the main websites used for our ANDis.',
        'https://and-digital.okta.com/app/UserHome', '2'),
       ('luna', 'Access Luna onboarding portal',
        'Once Okta has activated you can access your Luna onboarding portal to submit important information, find out how to prepare for your first week at AND',
        'https://luna.and-digital.com/onboarding', '3'),
       ('hdbi', 'HDBI Questionnaire',
        'Complete the HDBI Introduction under my journey, here you will learn the type of thinker you may relate to most.',
        'http://axon.herrmannsolutions.net', '4'),
       ('slack', 'Your community',
        'Join our dedicated onboarding channel on our messaging app Slack, where we will share daily updates throughout your onboarding.',
        'https://and-central.slack.com/archives/C0490RUMZ08', '1'),
       ('gmail', 'Access your Gmail',
        'Use this link to access your work gmail account, make sure you have your sso activated via okta',
        'https://mail.google.com', '6');

-- Add Keywords
INSERT INTO "keyword"("value")
VALUES ('before you start'),
       ('onboarding week'),
       ('okta'),
       ('apps'),
       ('home'),
       ('links'),
       ('sso'),
       ('luna'),
       ('onboarding'),
       ('laptop'),
       ('profile'),
       ('brain'),
       ('hdbi'),
       ('thinking'),
       ('slack'),
       ('community'),
       ('email'),
       ('gmail');

-- Add keywords to cards
INSERT INTO "card_keyword"("card_id", "keyword_id")
VALUES ('1', '1'),
       ('1', '3'),
       ('1', '4'),
       ('1', '5'),
       ('1', '6'),
       ('1', '7'),
       ('2', '1'),
       ('2', '8'),
       ('2', '9'),
       ('2', '10'),
       ('2', '11'),
       ('3', '1'),
       ('3', '12'),
       ('3', '13'),
       ('3', '14'),
       ('4', '2'),
       ('4', '15'),
       ('4', '16'),
       ('5', '2'),
       ('5', '17'),
       ('5', '18');