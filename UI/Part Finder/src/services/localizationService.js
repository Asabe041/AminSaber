import en from '../i18n/en'
import fr from '../i18n/fr'
//code inspired from https://medium.com/javascript-in-plain-english/making-your-react-app-multilingual-with-vanilla-javascript-6979937e7ede
const languages = {
    en,
    fr
};

let defaultLanguage = window.navigator.language === 'en' ? 'en' : 'fr';

window.i18nData = languages[defaultLanguage];

window.changeLanguage = (lang) => {
    window.i18nData = languages[lang];
}

window.i18n = (key) => window.i18nData[key];